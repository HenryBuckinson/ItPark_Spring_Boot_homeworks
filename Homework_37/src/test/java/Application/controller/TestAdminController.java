package Application.controller;

import Application.controller.rest.AdminRestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest({AdminRestController.class, SecurityController.class})
public class TestAdminController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetailsService detailsService;

    @WithMockUser(roles = {"ADMIN"})
    @Test
    @DisplayName("Получение страницы доступной только для администратора")
    public void getAdminPage() throws Exception {
        mockMvc.perform(get("/access/admin")
                        .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @WithMockUser(roles = {"USER"})
    @Test
    @DisplayName("Страница администратора недоступна для обычного пользователя")
    public void getAdminPageForUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/access/admin")
                .contentType(MediaType.TEXT_HTML)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(403);
    }

    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @Test
    @DisplayName("Получение информации об авторизованном пользователе")
    public void getAuthInfo() throws Exception {
        ResultActions perform = mockMvc.perform(get("/access/admin/info"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("admin")));
    }

}
