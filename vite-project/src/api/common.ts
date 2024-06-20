import request from "@/request";

// 响应接口
export interface GenerateImageCodeRes {
}

/**
 * 生成验证码
 * @returns
 */
export function generateImageCode(): Promise<GenerateImageCodeRes> {
    return request.get(`/basic/generateImageCode`, {responseType: "arraybuffer"});
}