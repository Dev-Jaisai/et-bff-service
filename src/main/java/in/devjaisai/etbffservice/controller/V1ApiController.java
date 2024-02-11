package in.devjaisai.etbffservice.controller;

import in.devjaisai.etbffservice.controller.mapper.AuthRequestMapper;
import in.devjaisai.etbffservice.controller.mapper.AuthResponseMapper;
import in.devjaisai.etbffservice.controller.mapper.VerifyTokenRequestMapper;
import in.devjaisai.etbffservice.controller.mapper.VerifyTokenResponseMapper;
import in.devjaisai.etbffservice.controller.model.AuthRequestDto;
import in.devjaisai.etbffservice.controller.model.AuthResponseDto;
import in.devjaisai.etbffservice.controller.model.VerifyTokenRequestDto;
import in.devjaisai.etbffservice.controller.model.VerifyTokenResponseDto;
import in.devjaisai.etbffservice.service.external.auth.AuthService;
import in.devjaisai.etbffservice.service.model.AuthRequest;
import in.devjaisai.etbffservice.service.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static in.devjaisai.etbffservice.constant.LoggingConstant.METHOD_LOG_END;
import static in.devjaisai.etbffservice.constant.LoggingConstant.METHOD_LOG_START;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class V1ApiController {


    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody AuthRequestDto authRequestDto) {
        log.info(METHOD_LOG_START, "signUo");
        AuthRequest authRequest = AuthRequestMapper.INSTANCE.toAuthRequest(authRequestDto);
        AuthResponse authResponse = authService.signUp(authRequest);
        log.info(METHOD_LOG_END, "signUo");
        AuthResponseDto authResponseDto = AuthResponseMapper.INSTANCE.toAuthResponseDto(authResponse);
        return ResponseEntity.status(HttpStatus.OK)
                .body(authResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
        log.info(METHOD_LOG_START, "login");
        AuthRequest authRequest = AuthRequestMapper.INSTANCE.toAuthRequest(authRequestDto);
        AuthResponse authResponse = authService.login(authRequest);
        log.info(METHOD_LOG_END, "login");
        AuthResponseDto authResponseDto = AuthResponseMapper.INSTANCE.toAuthResponseDto(authResponse);
        return ResponseEntity.status(HttpStatus.OK)
                .body(authResponseDto);
    }
    @PostMapping("/verify-token")
    public ResponseEntity<VerifyTokenResponseDto> verifyToken(@RequestBody VerifyTokenRequestDto verifyTokenRequestDto){
        log.info(METHOD_LOG_START, "verifyToken");
        var verifyTokenResponse = authService.verifyToken(VerifyTokenRequestMapper.INSTANCE.toVerifyTokenRequest(verifyTokenRequestDto));

        log.info(METHOD_LOG_END, "verifyToken");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(VerifyTokenResponseMapper.INSTANCE.toVerifyTokenResponseDto(verifyTokenResponse));
    }
}