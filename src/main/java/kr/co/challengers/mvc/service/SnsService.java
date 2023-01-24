package kr.co.challengers.mvc.service;

import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.repository.SnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnsService {

    @Autowired
    private SnsRepository snsRepository;

    public List<Sns> getStoryList(){
        return snsRepository.getStoryList();
    }

}
