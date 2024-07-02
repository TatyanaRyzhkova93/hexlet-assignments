package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public abstract class ProductMapper {
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "title", source = "name")
    @Mapping(target = "vendorCode", source = "barcode")
    public abstract ProductDTO map(Product product);

    @Mapping(target = "cost", source = "price")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO product);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product product);
}
