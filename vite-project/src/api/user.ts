import request from "@/request";

// 参数接口
export interface LoginParams {
    acc: string;
    pwd: string;
    code: string;
}

// 响应接口
export interface LoginRes {
    message: string;
    success: boolean;
    code: number;
    data: Record<string, unknown>;
}

/**
 * 用户登录
 * @param {object} params 登录参数
 * @param {string} params.acc 账号
 * @param {string} params.pwd 密码
 * @param {string} params.code 验证码
 * @returns
 */
export function login(params: LoginParams): Promise<LoginRes> {
    return request.post(`/userEntity/login`, params);
}