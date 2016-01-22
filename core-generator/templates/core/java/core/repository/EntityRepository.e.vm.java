$output.java($entity.extension.getRepositoryByProperty('core'))##

#if ($entity.hasUniqueBigIntegerAttribute())
$output.require("java.math.BigInteger")##
#end
#if ($entity.hasUniqueDateAttribute() || $entity.root.hasDatePk())
$output.require("java.util.Date")##
#end
$output.require($entity.core)##
$output.require($entity.root.primaryKey)##
#foreach ($enumAttribute in $entity.uniqueEnumAttributes.list)
$output.require($enumAttribute)##
#end
$output.require("org.springframework.data.jpa.repository.*")##

public interface $output.currentClass extends JpaRepository<$entity.model.type, $entity.root.primaryKey.type> {

}