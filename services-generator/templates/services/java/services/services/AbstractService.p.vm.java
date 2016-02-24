$output.java($Service, "AbstractService")##

$output.require("${configuration.rootPackage}.shared.services.Converter")##
$output.require("${configuration.rootPackage}.repository.Repository")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("org.springframework.util.Assert")##
$output.require("javax.annotation.PostConstruct")##
$output.require("java.lang.reflect.ParameterizedType")##
$output.require("java.lang.reflect.Type")##
$output.require("java.util.List")##
$output.require("java.util.Set")##
$output.require("java.io.Serializable")##
$output.require("net.leidra.demo.domain.support.Identifiable")##

public abstract class $output.currentClass<ENTITY extends Identifiable, DTO extends Dto, ID extends Serializable> implements Service<DTO, ID> {
    protected Repository<ENTITY, ID> repository;
    protected Converter converter;

    private Class<ENTITY> entityClass;
    private Class<DTO> dtoClass;

    @PostConstruct
    public void postConstruct() {
        configureMapper();
    }

    public DTO findOne(ID id) {
        ENTITY entity = this.repository.findOne(id);

        return converter.convertToDto(entity);
    }

    public Set<DTO> findAll() {
        List<ENTITY> entities = this.repository.findAll();

        return converter.convertToDtoSet(entities);
    }

    public DTO save(DTO dto) {
        Assert.notNull(dto);
        ENTITY entity = saveTransactional(dto);
        return converter.convertToDto(entity);
    }

    public void remove(DTO dto) {
        Assert.notNull(dto);
        this.remove((ID) dto.getId());
    }

    public void remove(ID id) {
        repository.delete(id);
    }

    protected abstract ENTITY saveTransactional(DTO dto);

    protected void configureMapper(){
        Type[]actualTypeArguments = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments();
        entityClass = (Class)actualTypeArguments[0];
        dtoClass = (Class)actualTypeArguments[1];
    }

    protected abstract void setRepository(Repository<ENTITY, ID> repository);
    protected abstract void setConverter(Converter converter);
}