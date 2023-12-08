package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class Test14StaticMethods {
    @InjectMocks
    private BookingService bookingService;
    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Mock
    //@Spy
    private BookingDAO bookingDAOMock;
    @Mock
    private MailSender mailSenderMock;
    @Captor
    private ArgumentCaptor<Double> doubleArgumentCaptor;


    @Test
    public void shouldCalculateCorrectPrice() {

        try(MockedStatic<CurrencyConverter> mockedConverter = mockStatic(CurrencyConverter.class)){

            //given
            BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                    LocalDate.of(2023, 01, 05), 2, false);
            double expected = 400.0;
            mockedConverter.when(()->CurrencyConverter.toEuro(anyDouble())).thenReturn(400.0);
            //when
            double actual = bookingService.calculatePriceEuro(bookingRequest);
            //then
            assertEquals(expected, actual);
        }


    }

}
