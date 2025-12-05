public class Test18 {
    enum UserRole {
        ADMIN("管理员权限: 增删改查"),
        USER("用户权限: 查看和修改"),
        GUEST("访客权限: 仅查看");
        private String permission;
        UserRole(String permission) {
            this.permission = permission;
        }
        public String getPermission() {
            return permission;
        }
    }
    public static void main(String[] args) {
        UserRole[] roles = UserRole.values();
        for (int i = 0; i < roles.length; i++) {
            UserRole role = roles[i];
            System.out.println(role.name() + ": " + role.getPermission());
        }
    }
}