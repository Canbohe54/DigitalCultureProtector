import * as home from "@/api/home";
import * as common from "@/api/common";
import * as user from "@/api/user";

interface api {
    common: typeof common;
    home: typeof home;
    user: typeof user;
}

export default {
    common,
    home,
    user
} as api;
