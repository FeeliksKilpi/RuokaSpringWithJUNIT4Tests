package com.harjoitustyo.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.harjoitustyo.domain.Ravintola;
import com.harjoitustyo.domain.Ruoka;
import com.harjoitustyo.domain.RuokaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RuokaRepositoryTest {

    @Autowired
    private RuokaRepository ruorepository;

    @Test
    public void findByNimiPalauttaaRuoan() {
        List<Ruoka> ruoat = ruorepository.findByNimi("Paella");
        
        assertThat(ruoat).hasSize(1);
        assertThat(ruoat.get(0).getNimi()).isEqualTo("Paella");
    }
    
    @Test
    public void luoUusiRuoka() {
    	Ruoka ruoka = new Ruoka("Hot-Dog", "liha", "-", 5.0, new Ravintola("Rafla X", "ravintola", "Stadi", 2));
    	ruorepository.save(ruoka);
    	assertThat(ruoka.getId()).isNotNull();
    }    

}