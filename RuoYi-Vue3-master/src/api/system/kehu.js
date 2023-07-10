import request from '@/utils/request'

// 查询111列表
export function listKehu(query) {
  return request({
    url: '/system/kehu/list',
    method: 'get',
    params: query
  })
}

// 查询111详细
export function getKehu(id) {
  return request({
    url: '/system/kehu/' + id,
    method: 'get'
  })
}

// 新增111
export function addKehu(data) {
  return request({
    url: '/system/kehu',
    method: 'post',
    data: data
  })
}

// 修改111
export function updateKehu(data) {
  return request({
    url: '/system/kehu',
    method: 'put',
    data: data
  })
}

// 删除111
export function delKehu(id) {
  return request({
    url: '/system/kehu/' + id,
    method: 'delete'
  })
}
