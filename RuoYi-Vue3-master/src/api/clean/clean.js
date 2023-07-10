import request from '@/utils/request'
//数据治理
export function upCompany() {
    return request({
        url: '/clean/company/cleancompany',
        method: 'get',
    })
}
//数据治理
export function upContainer() {
    return request({
        url: '/clean/Container/cleancontainer',
        method: 'get',
    })
}

//治理数据
export function upCustomer() {
    return request({
        url: '/clean/Customer/cleancustomer',
        method: 'get',
    })
}
//数据治理
export function upLogistics() {
    return request({
        url: '/clean/Logistics/logisticsclean',
        method: 'get',
    })
}
//治理数据
export function upWork() {
    return request({
        url: '/clean/WORK/workclean',
        method: 'get',
    })
}