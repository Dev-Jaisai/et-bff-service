package in.devjaisai.etbffservice.service.external;

import in.devjaisai.etbffservice.service.model.AuthRequest;
import in.devjaisai.etbffservice.service.model.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="et-use-auth-service", url= "http://localhost:8081/api/auth")
public interface UserAuthService {

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp( AuthRequest authRequest);
}
