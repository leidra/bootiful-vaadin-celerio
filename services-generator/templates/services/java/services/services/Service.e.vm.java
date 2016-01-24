$output.java($Service, "${entity.entityConfig.entityName}Service")##

$output.require($entity.model)##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("org.springframework.beans.factory.config.BeanDefinition")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("org.springframework.stereotype.Service")##
$output.require("org.springframework.transaction.annotation.Transactional")##

$output.require("java.util.List")##
$output.require("java.util.Set")##

@Service(${output.currentClass}.SERVICE_NAME)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class $output.currentClass  extends AbstractService<${entity.entityConfig.entityName}, ${entity.entityConfig.entityName}Dto> {
    public static final String SERVICE_NAME = "${output.currentClass}";

    @Transactional
    protected ${entity.entityConfig.entityName} saveTransactional(${entity.entityConfig.entityName}Dto dto) {
        ${entity.entityConfig.entityName} product = convertToEntity(dto);

        return repository.saveAndFlush(product);
    }

}
