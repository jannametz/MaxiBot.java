package hpi.proj1ct.maxivitaminbot.conrtoller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jana Metz on 02.06.23
 */
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/vitamins")
//@Tag(name = "Controller on managing vitamins")
public class VitaminController {
}
