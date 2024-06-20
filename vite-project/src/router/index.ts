import {createRouter, createWebHistory} from "vue-router";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/login",
            name: "登录",
            component: () => import("../views/LoginView.vue"),
        },
        {
            path: "/",
            name: "layout",
            redirect: "/home",
            component: () => import("../views/LayoutView.vue"),
            children: [
                {
                    path: "/home",
                    name: "首页",
                    component: () => import("../views/pages/HomeView.vue"),
                },
                {
                    path: "/institution",
                    name: "机构",
                    component: () => import("../views/pages/InstitutionView.vue"),
                },
                {
                    path: "/policy",
                    name: "政策",
                    component: () => import("../views/pages/PolicyView.vue"),
                },
                {
                    path: "/message",
                    name: "资讯",
                    component: () => import("../views/pages/MessageView.vue"),
                },
                {
                    path: "/detailed",
                    name: "清单",
                    component: () => import("../views/pages/DetailedView.vue"),
                },
                {
                    path: "/assets",
                    name: "资源",
                    component: () => import("../views/pages/AssetsView.vue"),
                },
                {
                    path: "/experience",
                    name: "体验",
                    component: () => import("../views/pages/ExperienceView.vue"),
                },
                {
                    path: "/science",
                    name: "学术",
                    component: () => import("../views/pages/ScienceView.vue"),
                },
                {
                    path: "/encyclopedia",
                    name: "百科",
                    component: () => import("../views/pages/EncyclopediaView.vue"),
                },
                {
                    path: "/myself",
                    name: "我的",
                    component: () => import("../views/pages/MyselfView.vue"),
                },
            ],
        },
    ],
});

export default router;
