export interface User {
    userid:       number;
    username:     string;
    email:        string;
    password:     string;
    rol:          Rol;
    creationdate: Date;
    usercreate:   number;
    userapproval: number;
    dateapproval: Date;
    userStatus:   UserStatus;
}

export interface Rol {
    rolId:   number;
    rolName: string;
}

export interface UserStatus {
    statusid:    string;
    description: string;
}
