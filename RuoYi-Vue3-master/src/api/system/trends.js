import request from '@/utils/request'

// 查询集装箱动态列表
export function listTrends(query) {
  return request({
    url: '/system/trends/list',
    method: 'get',
    params: query
  })
}

// 查询集装箱动态详细
export function getTrends(id) {
  return request({
    url: '/system/trends/' + id,
    method: 'get'
  })
}

// 新增集装箱动态
export function addTrends(data) {
  return request({
    url: '/system/trends',
    method: 'post',
    data: data
  })
}

// 修改集装箱动态
export function updateTrends(data) {
  return request({
    url: '/system/trends',
    method: 'put',
    data: data
  })
}

// 删除集装箱动态
export function delTrends(id) {
  return request({
    url: '/system/trends/' + id,
    method: 'delete'
  })
}
