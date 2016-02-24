$output.java($Service, "${entity.entityConfig.entityName}Service")##

$output.require($entity.model)##
$output.require(${entity.repository})##
$output.require("${configuration.rootPackage}.repository.Repository")##
$output.require("${configuration.rootPackage}.shared.services.Converter")##
$output.require("org.slf4j.Logger")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("org.springframework.beans.factory.config.BeanDefinition")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("net.leidra.demo.service.Service")##
$output.require("org.springframework.transaction.annotation.Transactional")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}ListDto")##
$output.require("${configuration.rootPackage}.shared.services.${entity.entityConfig.entityName}Converter")##
$output.require($Service, "AbstractService")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("org.springframework.beans.factory.annotation.Qualifier")##
$output.require("java.util.List")##
$output.require("java.util.Set")##

@org.springframework.stereotype.Service(${output.currentClass}.SERVICE_NAME)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class $output.currentClass extends AbstractService<${entity.entityConfig.entityName}, ${entity.entityConfig.entityName}Dto, $entity.primaryKey.type> {
    public static final String SERVICE_NAME = "${output.currentClass}";
    private static final Logger LOG = LoggerFactory.getLogger(${output.currentClass}.class);

    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Repository.REPOSITORY_NAME)
    protected void setRepository(Repository<${entity.entityConfig.entityName}, $entity.primaryKey.type> repository) {
        this.repository = repository;
    }

    @Autowired
    @Qualifier(${entity.entityConfig.entityName}Converter.CONVERTER_NAME)
    protected void setConverter(Converter converter) {
        this.converter = converter;
    }

    @Transactional
    protected ${entity.entityConfig.entityName} saveTransactional(${entity.entityConfig.entityName}Dto dto) {
        ${entity.entityConfig.entityName} product = converter.convertToEntity(dto);

        return repository.saveAndFlush(product);
    }

    public Set<${entity.entityConfig.entityName}ListDto> findAllForList() {
        List<${entity.entityConfig.entityName}> entities = this.repository.findAll();

        return converter.convertToListDtoSet(entities);
    }
}