$output.java($entity.repository)##

$output.require($entity.model)##
$output.require($entity.root.primaryKey)##

@org.springframework.stereotype.Repository(value = ${output.currentClass}.REPOSITORY_NAME)
public interface $output.currentClass extends Repository<$entity.model.type, $entity.root.primaryKey.type> {
    String REPOSITORY_NAME = "${output.currentClass}";
}