package kr.co.challengers.mvc.mapper;

import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.parameter.SnsRequestParameter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnsMapStructTest {

    @Test
    public void testMapping(){
        SnsRequestParameter s = new SnsRequestParameter();//source
        s.setUserId( "5" );

        Sns t = SnsMapper.INSTANCE.dtoToEntity(s);
        assertEquals( 5, t.getUserId() );

        System.out.println("Passed!");
    }

}
