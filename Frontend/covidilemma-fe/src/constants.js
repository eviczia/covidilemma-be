import axios from "axios";

export const URL = "https://localhost:3000";
export const API_URL = "https://localhost:3000";
export const my_app = axios.create({ baseURL: API_URL });
