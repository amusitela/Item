import request from '@/utils/request'
//数据治理
export function mysqlrequest(data) {
    return request({
        url: '/getdata/mysql',
        method: 'post',
        data: data
    })
}
export function hdfsrequest(data) {
    return request({
        url: '/getdata/hdfs',
        method: 'post',
        data: data
    })
}
export function miniorequest(data) {
    return request({
        url: '/getdata/minio',
        method: 'post',
        data: data
    })
}