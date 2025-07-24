package ru.mts.media.platform.umc.dao.postgres.venue;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mts.media.platform.umc.dao.postgres.common.FullExternalIdPk;
import ru.mts.media.platform.umc.domain.gql.types.FullExternalId;
import ru.mts.media.platform.umc.domain.gql.types.Venue;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface VenuePgMapper {
    @Mapping(target = "externalId.brand", source = "brand")
    @Mapping(target = "externalId.provider", source = "provider")
    @Mapping(target = "externalId.externalId", source = "externalId")
    @Mapping(target = "id", source = "referenceId")
    Venue asModel(VenuePgEntity venuePg);

    @Mapping(target = "referenceId", source = "id")
    @Mapping(target = "brand", source = "externalId.brand")
    @Mapping(target = "provider", source = "externalId.provider")
    @Mapping(target = "externalId", source = "externalId.externalId")
    VenuePgEntity asEntity(Venue venue);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "provider", source = "provider")
    @Mapping(target = "externalId", source = "externalId")
    FullExternalIdPk asPk(FullExternalId fullExternalId);
}
