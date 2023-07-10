package com.tsemkalo.businesscards;


import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dao.NonActivatedUserDao;
import com.tsemkalo.businesscards.dao.PermissionDao;
import com.tsemkalo.businesscards.dao.RoleDao;
import com.tsemkalo.businesscards.dao.UserDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.Permission;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.mapper.NonActivatedUserMapper;
import com.tsemkalo.businesscards.mapper.PermissionMapper;
import com.tsemkalo.businesscards.mapper.RoleMapper;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@Setter
@Getter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTest {
    @Mock
    private NonActivatedUserDao nonActivatedUserDao;

    @Mock
    private RoleDao roleDao;

    @Mock
    private PermissionDao permissionDao;

    @Mock
    private UserDao userDao;

    @Spy
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Spy
    @InjectMocks
    private UserMapper userMapper;

    @Spy
    @InjectMocks
    private RoleMapper roleMapper;

    @Spy
    @InjectMocks
    private PermissionMapper permissionMapper;

    @Spy
    @InjectMocks
    private NonActivatedUserMapper nonActivatedUserMapper;

    @Spy
    @InjectMocks
    private SafeUserMapper safeUserMapper;

    private Map<Long, NonActivatedUser> nonActivatedUserTable = new HashMap<>();
    private Map<Long, User> userTable = new HashMap<>();
    private Map<Long, Role> roleTable = new HashMap<>();
    private Map<Long, Permission> permissionTable = new HashMap<>();

    private CommonMethodsSetUpper<User> userCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<NonActivatedUser> nonActivatedUserCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Role> roleCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Permission> permissionCommonMethodsSetUpper = new CommonMethodsSetUpper<>();

    @BeforeEach
    public void fillDB() {
        nonActivatedUserTable = new HashMap<>();
        userTable = new HashMap<>();
        roleTable = new HashMap<>();
        permissionTable = new HashMap<>();
        fillRoleTable();
        fillPermissionTable();
        fillUserTable();
        fillNonActivatedUserTable();
    }

    @BeforeEach
    public void setup() {
        userDaoSetup();
        nonActivatedUserDaoSetup();
        roleDaoSetup();
        permissionDaoSetup();
    }

    private void fillRoleTable() {
        addRole(1L, RoleType.ADMIN);
        addRole(2L, RoleType.TECHNICAL_SUPPORT);
        addRole(3L, RoleType.USER);
    }

    public void addRole(Long id, RoleType name) {
        Role role = new Role(name);
        role.setId(id);
        role.setPermissions(new ArrayList<>());
        roleTable.put(id, role);
    }

    private void fillPermissionTable() {
        addPermission(1L, PermissionType.READ, roleTable.get(1L));
        addPermission(2L, PermissionType.READ, roleTable.get(2L));
        addPermission(3L, PermissionType.READ, roleTable.get(3L));
        addPermission(4L, PermissionType.EDIT, roleTable.get(1L));
        addPermission(5L, PermissionType.EDIT, roleTable.get(2L));
        addPermission(6L, PermissionType.EDIT, roleTable.get(3L));
        addPermission(7L, PermissionType.FOLLOW_LIKE, roleTable.get(3L));
        addPermission(8L, PermissionType.CHAT, roleTable.get(1L));
        addPermission(9L, PermissionType.CHAT, roleTable.get(2L));
        addPermission(10L, PermissionType.CHAT, roleTable.get(3L));
        addPermission(11L, PermissionType.CONTROL_SUPPORT, roleTable.get(1L));
        addPermission(12L, PermissionType.RESOLVE_QUESTIONS, roleTable.get(2L));
    }

    public void addPermission(Long id, PermissionType name, Role role) {
        Permission permission = new Permission();
        permission.setId(id);
        permission.setName(name);
        permission.setRole(role);
        role.getPermissions().add(permission);
        permissionTable.put(id, permission);
    }

    private void fillUserTable() {
        addUser(1L, "svetlana", "$2a$10$eHrKX3q0Gi.K3IXxDVSnmevyIf.LLq/DEAoHCMSCkIPDsOQsrix7W", "Svetlana", "Oleina", roleTable.get(1L), "tsemkaloalena@gmail.com");
        addUser(2L, "amy", "$2a$10$uURzRp0Dr/iC5GEP3POsPeEvpF8GBfy1WNx0l2eNbM/WyvyrZHV4S", "Amy", "Norton", roleTable.get(2L), "tsemkaloalena@gmail.com");
        addUser(3L, "rav", "$2a$10$K9VIDic.2ZRNlDUn5Ex8p.WztqJ9VnFz935itAylM3/zMCV9TGTjW", "Rav", "Ahuja", roleTable.get(2L), "tsemkaloalena@gmail.com");
        addUser(4L, "robby", "$2a$10$YIePp00IQCDH5cSjZdcBAeBmKJUJ8QjaJh.bKjPA51kW30PBpic.K", "Robert", "Shiller", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(5L, "nadya", "$2a$10$6pY.lRuSXtWLupFhyHzZD.uyoRojk6ecvKGBqlJ5WllPdfFdOE3Vi", "Nader", "Tavassoli", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(6L, "rohit", "$2a$10$d4rss2UUzw1jY0m6m8eZxOIJSAwocb0oelOhpPTjHw1GW/1XlBw42", "Rohit", "Rahi", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(7L, "pasha", "$2a$10$YAy0lNUFouUPvxJZoFaYR.uwV2uKNJz8hdbmJ9dA4M.LCJbgD/jXi", "Pavel", "Pevzner", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(8L, "philya", "$2a$10$gLr2A2aU1w8C6JV2x0CZKuAtaUvbtHO.whMinTKaOnvx.ggTwPyme", "Phillip", "Compeau", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(9L, "lisa", "$2a$10$bbP1/bhs/ByqDYsQtg.FFO3M7Qwoiug5p8cPhQWX2xqBtn7anYoOq", "Lisa", "Mazzola", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(10L, "marik", "$2a$10$h2O/buH8cHiKx6eSgFuhs..c5fB15lu2Bi1SRSMpq3d8nTJBhJROW", "Marik", "Thewho", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(11L, "edik", "$2a$10$5ufPvlwI5MBXQDa/7wIdsuHneB2/ppWSAn5cz5tmhA2NuMjwrg2DS", "Edik", "NotYarik", roleTable.get(3L), "tsemkaloalena@gmail.com");
        addUser(12L, "derevo", "$2a$10$qOIhlqKOgDb0Ftrv5cn/zOGnPIa1Rv5p83TxhiHZOnOMORkXwBVuC", "Drevo", "Obrabotka", roleTable.get(3L), "tsemkaloalena@gmail.com");
    }

    public void addUser(Long id, String username, String password, String name, String surname, Role role, String email) {
        User user = new User(id, username, password, name, surname, role, email);
        userTable.put(id, user);
    }

    private void fillNonActivatedUserTable() {
        addNonActivatedUser(1L, "sashenka", "$2a$10$bo4DgfkF4rXX2x0iO3Xn0eMvBGm4wOvxOkx0utSPrdnml2/V/r32.", "Danya", "Saharok", roleTable.get(3L), "tsemkaloalena@gmail.com");
    }

    public void addNonActivatedUser(Long id, String username, String password, String name, String surname, Role role, String email) {
        NonActivatedUser nonActivatedUser = new NonActivatedUser();
        nonActivatedUser.setId(id);
        nonActivatedUser.setUsername(username);
        nonActivatedUser.setPassword(password);
        nonActivatedUser.setName(name);
        nonActivatedUser.setSurname(surname);
        nonActivatedUser.setEmail(email);
        nonActivatedUser.setRole(role);
        nonActivatedUserTable.put(id, nonActivatedUser);
    }

    private void userDaoSetup() {
        userCommonMethodsSetUpper.findAllSetup(userTable, userDao);
        userCommonMethodsSetUpper.findByIdSetup(userTable, userDao);
        userCommonMethodsSetUpper.saveSetup(userTable, userDao, User.class);
        userCommonMethodsSetUpper.deleteSetup(userTable, userDao, User.class);
        userCommonMethodsSetUpper.deleteByIdSetup(userTable, userDao);
        lenient().doAnswer(invocationOnMock -> {
            String username = invocationOnMock.getArgument(0);
            for (User user : userTable.values()) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }).when(userDao).findByUsername(any(String.class));
    }

    private void nonActivatedUserDaoSetup() {
        nonActivatedUserCommonMethodsSetUpper.findAllSetup(nonActivatedUserTable, nonActivatedUserDao);
        nonActivatedUserCommonMethodsSetUpper.findByIdSetup(nonActivatedUserTable, nonActivatedUserDao);
        nonActivatedUserCommonMethodsSetUpper.saveSetup(nonActivatedUserTable, nonActivatedUserDao, NonActivatedUser.class);
        nonActivatedUserCommonMethodsSetUpper.deleteSetup(nonActivatedUserTable, nonActivatedUserDao, NonActivatedUser.class);
        nonActivatedUserCommonMethodsSetUpper.deleteByIdSetup(nonActivatedUserTable, nonActivatedUserDao);
        lenient().doAnswer(invocationOnMock -> {
            String username = invocationOnMock.getArgument(0);
            for (NonActivatedUser user : nonActivatedUserTable.values()) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }).when(nonActivatedUserDao).findByUsername(any(String.class));
    }

    private void roleDaoSetup() {
        roleCommonMethodsSetUpper.findAllSetup(roleTable, roleDao);
        roleCommonMethodsSetUpper.findByIdSetup(roleTable, roleDao);
        roleCommonMethodsSetUpper.saveSetup(roleTable, roleDao, Role.class);
        roleCommonMethodsSetUpper.deleteSetup(roleTable, roleDao, Role.class);
        roleCommonMethodsSetUpper.deleteByIdSetup(roleTable, roleDao);
        lenient().doAnswer(invocationOnMock -> {
            RoleType name = invocationOnMock.getArgument(0);
            for (Role role : roleTable.values()) {
                if (role.getName().equals(name)) {
                    return role;
                }
            }
            return null;
        }).when(roleDao).findByName(any(RoleType.class));
    }

    private void permissionDaoSetup() {
        permissionCommonMethodsSetUpper.findAllSetup(permissionTable, permissionDao);
        permissionCommonMethodsSetUpper.findByIdSetup(permissionTable, permissionDao);
        permissionCommonMethodsSetUpper.saveSetup(permissionTable, permissionDao, Permission.class);
        permissionCommonMethodsSetUpper.deleteSetup(permissionTable, permissionDao, Permission.class);
        permissionCommonMethodsSetUpper.deleteByIdSetup(permissionTable, permissionDao);
    }
}
