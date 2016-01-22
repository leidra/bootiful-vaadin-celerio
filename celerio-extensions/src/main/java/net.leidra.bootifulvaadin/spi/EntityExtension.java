package net.leidra.bootifulvaadin.spi;

import com.jaxio.celerio.convention.ClassType;
import com.jaxio.celerio.convention.GeneratedPackage;
import com.jaxio.celerio.model.Entity;
import com.jaxio.celerio.model.support.ClassNamer;
import com.jaxio.celerio.model.support.ClassNamer2;
import com.jaxio.celerio.spi.EntitySpi;
import com.jaxio.celerio.util.StringUtil;
import org.apache.commons.lang.StringUtils;

public class EntityExtension implements EntitySpi {

    private Entity entity;

    @Override
    public void init(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String velocityVar() {
        return "extension";
    }

    public Object getTarget() {
        return this;
    }

    public ClassNamer2 getEntityByProperty(String property) {
        ClassNamer2 propertyNamer = (ClassNamer2)this.entity.get(property);
        String packageName = propertyNamer.getPackageName();

        return new ClassNamer2(this.entity, packageName, "", "", "");
    }

    public ClassNamer2 getDtoByProperty(String property) {
        ClassNamer2 propertyNamer = (ClassNamer2)this.entity.get(property);
        String packageName = propertyNamer.getPackageName();

        return new ClassNamer2(this.entity, packageName, "", "", "Dto");
    }

    public ClassNamer2 getRepositoryByProperty(String property) {
        ClassNamer2 propertyNamer = (ClassNamer2)this.entity.get(property);
        String packageName = StringUtils.replace(propertyNamer.getPackageName(), GeneratedPackage.Model.getSubPackage(), GeneratedPackage.Repository.getSubPackage());

        return new ClassNamer2(this.entity, packageName, "", "", GeneratedPackage.Repository.name());
    }
}