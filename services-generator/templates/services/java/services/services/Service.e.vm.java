$output.java($Service, "${entity.entityConfig.entityName}Service")##

$output.require($entity.model)##
$output.require(${entity.repository})##
$output.require("org.slf4j.Logger")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("org.springframework.beans.factory.config.BeanDefinition")##
$output.require("org.springframework.context.annotation.Scope")##
$output.require("net.leidra.demo.service.Service")##
$output.require("org.springframework.transaction.annotation.Transactional")##
$output.require("org.springframework.beans.factory.annotation.Autowired")##
$output.require("${configuration.rootPackage}.shared.dtos.${entity.entityConfig.entityName}Dto")##
$output.require("${configuration.rootPackage}.shared.services.${entity.entityConfig.entityName}Converter")##
$output.require("java.util.List")##
$output.require("java.util.Set")##
$output.require("org.springframework.util.Assert")##
$output.require($Service, "${entity.entityConfig.entityName}Service")##

@org.springframework.stereotype.Service(${output.currentClass}.SERVICE_NAME)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class $output.currentClass implements Service<${entity.entityConfig.entityName}Dto, $entity.primaryKey.type> {
    public static final String SERVICE_NAME = "${output.currentClass}";
    private static final Logger LOG = LoggerFactory.getLogger(${output.currentClass}.class);

    @Autowired
    protected ${entity.repository.type} repository;
    @Autowired
    protected ${entity.entityConfig.entityName}Converter converter;

    public ${entity.entityConfig.entityName}Dto findOne($entity.primaryKey.type id) {
        ${entity.entityConfig.entityName} entity = this.repository.findOne(id);

        return converter.convertToDto(entity);
    }

    public Set<${entity.entityConfig.entityName}Dto> findAll() {
        List< ${entity.entityConfig.entityName}> entities = this.repository.findAll();

        return converter.convertToDtoSet(entities);
    }

    public ${entity.entityConfig.entityName}Dto save(${entity.entityConfig.entityName}Dto dto) {
        Assert.notNull(dto);
        ${entity.entityConfig.entityName} entity = saveTransactional(dto);
        return converter.convertToDto(entity);
    }

    public void remove(${entity.entityConfig.entityName}Dto dto) {
        Assert.notNull(dto);
        this.remove(dto.getId());
    }

    public void remove($entity.primaryKey.type id) {
        repository.delete(id);
    }

    @Transactional
    protected ${entity.entityConfig.entityName} saveTransactional(${entity.entityConfig.entityName}Dto dto) {
        ${entity.entityConfig.entityName} product = converter.convertToEntity(dto);

        return repository.saveAndFlush(product);
    }

}