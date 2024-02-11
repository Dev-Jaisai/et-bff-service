package in.devjaisai.etbffservice.service.external.auth;

import in.devjaisai.etbffservice.service.external.UserAuthService;
import in.devjaisai.etbffservice.service.model.AuthRequest;
import in.devjaisai.etbffservice.service.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static in.devjaisai.etbffservice.constant.LoggingConstant.METHOD_LOG_END;
import static in.devjaisai.etbffservice.constant.LoggingConstant.METHOD_LOG_START;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserAuthService userAuthService;

    @Override
    public AuthResponse signUp(AuthRequest authRequest) {
        log.info("Into the method signUp of gateway to call Fiegn client");
        var responseEntity = userAuthService.signUp(authRequest);
        log.info("Successs of signUp from fien client");
        return responseEntity.getBody();
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        log.info("Into the method login of gateway to call Fiegn client");
        var responseEntity = userAuthService.login(authRequest);
        log.info("Successs of login from fien client");
        return responseEntity.getBody();
    }

    @Override
    public VerifyTokenResponse verifyToken(VerifyTokenRequest verifyTokenRequest) {
        log.info(METHOD_LOG_START, "verifyToken");
        var responseEntity = userAuthService.verifyToken(verifyTokenRequest);
        log.info(METHOD_LOG_END, "verifyToken");
        return responseEntity.getBody();
    }
}
