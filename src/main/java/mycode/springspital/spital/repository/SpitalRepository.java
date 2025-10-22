package mycode.springspital.spital.repository;

import mycode.springspital.spital.models.Spital;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SpitalRepository {
    void load();
    List<Spital>getAllSpital();
}
