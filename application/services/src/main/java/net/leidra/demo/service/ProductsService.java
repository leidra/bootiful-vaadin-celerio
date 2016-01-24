/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-backend-services:java/services/services/Service.e.vm.java
 */
package net.leidra.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.leidra.demo.domain.Products;
import net.leidra.demo.shared.dtos.ProductsDto;

@Service(ProductsService.SERVICE_NAME)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ProductsService extends AbstractService<Products, ProductsDto> {
    public static final String SERVICE_NAME = "ProductsService";

    @Transactional
    protected Products saveTransactional(ProductsDto dto) {
        Products product = convertToEntity(dto);

        return repository.saveAndFlush(product);
    }

}
