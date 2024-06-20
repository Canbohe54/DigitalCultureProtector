import {defineStore} from "pinia";

/**
 * 其内部可以包含，
 * 状态（state），
 * 操作（actions）,
 * getter（getters）
 */
export const index = defineStore("index", {
    state: () => ({
        //选中菜单信息
        selectedKeys: "/home",
        myself: ''
    }),
    persist: {
        enabled: true
    },
    actions: {
        changeSelectedKeys(key: any) {
            //@ts-ignore
            this.selectedKeys = key;
        },
        changeMysef(param: any) {
            //@ts-ignore
            this.myself = param
        }
    },
    getters: {}
});
