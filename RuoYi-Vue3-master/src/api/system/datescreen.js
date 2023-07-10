import request from '@/utils/request'

// 根据港口查询数据
export function getInfo(data) {
    return request({
      url: '/visual/thput',
      method: 'get',
      params: {
        port:data.port,
        goods:data.goods,
        start:data.start,
        end:data.end
      }
    })
}
  