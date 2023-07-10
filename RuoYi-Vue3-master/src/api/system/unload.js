import request from '@/utils/request'

// 查询卸货表列表
export function listUnload(query) {
  return request({
    url: '/system/unload/list',
    method: 'get',
    params: query
  })
}

// 查询卸货表详细
export function getUnload(id) {
  return request({
    url: '/system/unload/' + id,
    method: 'get'
  })
}

// 新增卸货表
export function addUnload(data) {
  return request({
    url: '/system/unload',
    method: 'post',
    data: data
  })
}

// 修改卸货表
export function updateUnload(data) {
  return request({
    url: '/system/unload',
    method: 'put',
    data: data
  })
}

// 删除卸货表
export function delUnload(id) {
  return request({
    url: '/system/unload/' + id,
    method: 'delete'
  })
}
