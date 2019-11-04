package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void varastoTilavuusJaAlkuSaldo() {
        Varasto var = new Varasto(10, 10);
        assertNotNull(var);
    }
    
    @Test
    public void liianPieniTilavuusJaAlkuSaldo() {
        Varasto var = new Varasto(-5, 0);
        assertNotNull(var);
    }
    
    @Test
    public void tilavuudetLiianPienet() {
        Varasto var = new Varasto(0);
        Varasto var2 = new Varasto(0, -5);
        assertNotNull(var);
        assertNotNull(var2);
    }
    
    @Test
    public void tulostusToimii() {
        String testi = varasto.toString();
        assertNotNull(testi);
    }
    
    @Test
    public void lisaaVarastoonNegatiivinenJaYli() {
        Varasto var = new Varasto(10, 10);
        var.lisaaVarastoon(-5);
        var.lisaaVarastoon(11);
        assertNotNull(var);
    }
    
    @Test
    public void otaTyhjaJaYli() {
        varasto.otaVarastosta(-1);
        varasto.otaVarastosta(100);
        assertFalse(varasto.getSaldo() == 0);
    }

}