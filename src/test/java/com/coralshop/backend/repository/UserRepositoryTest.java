package com.coralshop.backend.repository;

import com.coralshop.backend.entity.Role;
import com.coralshop.backend.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
// La siguiente línea indica que usaremos nuestra base de datos PostgreSQL real configurada en application.yml
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void dadoUnEmail_cuandoBuscoPorEmail_entoncesRetornaElUsuario() {
        // 1. Arrange (Preparar los datos de prueba)
        Role role = new Role();
        role.setName("ROLE_ADMIN_TEST");
        roleRepository.save(role);

        User user = new User();
        user.setUsername("testuser");
        user.setEmail("admin@coralshop.com");
        user.setPasswordHash("hash123");
        user.setRole(role);
        userRepository.save(user);

        // 2. Act (Ejecutar la función que queremos probar)
        Optional<User> userEncontrado = userRepository.findByEmail("admin@coralshop.com");

        // 3. Assert (Verificar que el resultado es el esperado)
        assertThat(userEncontrado).isPresent(); // Afirmamos que sí encontró algo (no es nulo)
        assertThat(userEncontrado.get().getUsername()).isEqualTo("testuser"); // Afirmamos que es el usuario correcto
    }
}
