export class SignUpInfo {
    deleteFlag: string;
    name: string;
    username: string;
    email: string;
    role: string[];
    password: string;

    constructor(name: string, username: string, email: string, password: string, deleteFlag:string) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.deleteFlag = deleteFlag;
        this.role = ['user'];

    }
}
