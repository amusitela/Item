import request from '@/utils/request'


// 查询company列表
export function listCompany(query) {
  return request({
    url: '/clean/company/list',
    method: 'get',
    params: query
  })
}

// 查询company详细
export function getCompany(companyNum) {
  return request({
    url: '/clean/company/' + companyNum,
    method: 'get'
  })
}

// 新增company
export function addCompany(data) {
  return request({
    url: '/clean/company',
    method: 'post',
    data: data
  })
}

// 修改company
export function updateCompany(data) {
  return request({
    url: '/clean/company',
    method: 'put',
    data: data
  })
}

// 删除company
export function delCompany(companyNum) {
  return request({
    url: '/clean/company/' + companyNum,
    method: 'delete'
  })
}
