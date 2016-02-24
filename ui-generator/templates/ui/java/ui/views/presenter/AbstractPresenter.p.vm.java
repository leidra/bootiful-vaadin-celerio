$output.java("${configuration.rootPackage}.web.ui.presenter","AbstractPresenter")##

$output.require("com.vaadin.data.util.BeanItemContainer")##
$output.require("${configuration.rootPackage}.service.Service")##
$output.require("${configuration.rootPackage}.shared.dtos.Dto")##
$output.require("${configuration.rootPackage}.web.ui.views.AbstractView")##
$output.require("java.lang.reflect.ParameterizedType")##
$output.require("java.io.Serializable")##

public abstract class $output.currentClass<BEAN extends Dto, ID extends Serializable> implements Presenter<BEAN, ID> {
    protected Service<BEAN, ID> service;

    protected abstract AbstractView getCurrentView();

    public void edit(BEAN dto) {
        if (dto.getId() != null) {
            dto = getService().findOne((ID) dto.getId());
        }

        getCurrentView().getEditor().setDatasource(dto);
        getCurrentView().changeViewComponent(getCurrentView().getEditor());
    }

    public void remove(BEAN dto) {
        getService().remove((ID) dto.getId());

        this.showList();
    }

    public void showList() {
        getCurrentView().getList().refresh();
        getCurrentView().changeViewComponent(getCurrentView().getList());
    }

    public BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(getType(), findAll());
    }

    protected Class<BEAN> getType() {
        return (Class<BEAN>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Service<BEAN, ID> getService() {
        return this.service;
    }
}