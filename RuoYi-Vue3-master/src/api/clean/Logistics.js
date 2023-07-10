import request from '@/utils/request'


// 查询Logistics列表
export function listLogistics(query) {
  return request({
    url: '/clean/Logistics/list',
    method: 'get',
    params: query
  })
}

// 查询Logistics详细
export function getLogistics(tNum) {
  return request({
    url: '/clean/Logistics/' + tNum,
    method: 'get'
  })
}

// 新增Logistics
export function addLogistics(data) {
  return request({
    url: '/clean/Logistics',
    method: 'post',
    data: data
  })
}

// 修改Logistics
export function updateLogistics(data) {
  return request({
    url: '/clean/Logistics',
    method: 'put',
    data: data
  })
}

// 删除Logistics
export function delLogistics(tNum) {
  return request({
    url: '/clean/Logistics/' + tNum,
    method: 'delete'
  })
}
