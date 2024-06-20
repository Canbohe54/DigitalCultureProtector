import request from "@/request";

// 响应接口
export interface MapCultureRes {
    message: string;
    success: boolean;
    code: number;
    data: {
        id: number;
        city: string;
        code: string;
        serial: string;
        name: string;
        category: number;
        announce: string;
        type: string;
        reporting: string;
        protection: string;
    }[];
}

/**
 * 获取地图数据
 * @param {string} city
 * @returns
 */
export function mapCulture(city: string): Promise<MapCultureRes> {
    return request.get(`/cultureEntity/map?city=${city}`);
}