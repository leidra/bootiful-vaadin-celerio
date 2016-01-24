$output.java($Repository, "Repository")##

$output.require("org.springframework.data.jpa.repository.JpaRepository")##
$output.require("org.springframework.data.repository.NoRepositoryBean")##
$output.require("java.io.Serializable")##

@NoRepositoryBean
public interface $output.currentClass<T, ID extends Serializable> extends JpaRepository<T, ID> {
}