package code.craft.documents;

import code.craft.documents.Utils.MysqlContextInitializer
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(initializers = [MysqlContextInitializer::class])
class CodeCraftDocumentsApplicationTests {
	@Test
	fun contextLoads() {
		assertTrue(true)
	}

}
