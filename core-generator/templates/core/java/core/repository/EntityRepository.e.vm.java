$output.java($entity.repository)##

$output.require($entity.model)##
$output.require($entity.root.primaryKey)##

public interface $output.currentClass extends Repository<$entity.model.type, $entity.root.primaryKey.type> {

}