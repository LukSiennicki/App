package pl.siennicki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class CurrencyApiTest {

    @Mock
    Client client;
    private CurrencyApi sut;
    private JsonDataConverter dataConverter;

    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        dataConverter = new JsonDataConverter();
        sut = new CurrencyApi(client,  dataConverter);
    }

    @Test
    public void should_convert_json_data() throws IOException {
        final String jsonString = "{\"table\":\"C\",\"currency\":\"dolar amerykański\",\"code\":\"USD\"" +
                ",\"rates\":[{\"no\":\"173/C/NBP/2020\",\"effectiveDate\":\"2020-09-04\",\"bid\":3.7064,\"ask\":3.7812}]}";

        Mockito.when(client.executeRequest(Currency.USD,DataFormat.JSON)).thenReturn(jsonString);
        Mockito.when(client.executeRequest(Currency.EUR,DataFormat.JSON)).thenReturn(jsonString);

        CurrencyInfo currencyInfo = sut.getInfoForCurrency(Currency.EUR);

        Assert.assertEquals(3.7064,currencyInfo.getSell(), DELTA);
        Assert.assertEquals(3.7812,currencyInfo.getBuy(), DELTA);
        Assert.assertEquals("dolar amerykański",currencyInfo.getName());
        Assert.assertEquals("2020-09-04",currencyInfo.getDate().toString());
    }
}