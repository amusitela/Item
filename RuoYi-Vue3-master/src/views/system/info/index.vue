<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="货主名称" prop="owner">
        <el-input
          v-model="queryParams.owner"
          placeholder="请输入货主名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货主代码" prop="ownerNum">
        <el-input
          v-model="queryParams.ownerNum"
          placeholder="请输入货主代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流公司" prop="tranCompany">
        <el-input
          v-model="queryParams.tranCompany"
          placeholder="请输入物流公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集装箱号" prop="boxNum">
        <el-input
          v-model="queryParams.boxNum"
          placeholder="请输入集装箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货物名称" prop="goods">
        <el-input
          v-model="queryParams.goods"
          placeholder="请输入货物名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货重" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入货重"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="提单号" align="center" prop="id" />
      <el-table-column label="货主名称" align="center" prop="owner" />
      <el-table-column label="货主代码" align="center" prop="ownerNum" />
      <el-table-column label="物流公司" align="center" prop="tranCompany" />
      <el-table-column label="集装箱号" align="center" prop="boxNum" />
      <el-table-column label="货物名称" align="center" prop="goods" />
      <el-table-column label="货重" align="center" prop="weight" />
      <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改物流信息对话框 -->
    <el-dialog :title="title" v-model="updateopen" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="货主名称" prop="owner">
          <el-input v-model="form.owner" placeholder="请输入货主名称" />
        </el-form-item>
        <el-form-item label="货主代码" prop="ownerNum">
          <el-input v-model="form.ownerNum" placeholder="请输入货主代码" />
        </el-form-item>
        <el-form-item label="物流公司" prop="tranCompany">
          <el-input v-model="form.tranCompany" placeholder="请输入物流公司" />
        </el-form-item>
        <el-form-item label="集装箱号" prop="boxNum">
          <el-input v-model="form.boxNum" placeholder="请输入集装箱号" />
        </el-form-item>
        <el-form-item label="货物名称" prop="goods">
          <el-input v-model="form.goods" placeholder="请输入货物名称" />
        </el-form-item>
        <el-form-item label="货重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入货重" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="updateForm">确 定</el-button>
        <el-button @click="updatecancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog :title="title" v-model="addopen" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="提单号" prop="id">
          <el-input v-model="form.id" placeholder="请输入提单号" />
        </el-form-item>
        <el-form-item label="货主名称" prop="owner">
          <el-input v-model="form.owner" placeholder="请输入货主名称" />
        </el-form-item>
        <el-form-item label="货主代码" prop="ownerNum">
          <el-input v-model="form.ownerNum" placeholder="请输入货主代码" />
        </el-form-item>
        <el-form-item label="物流公司" prop="tranCompany">
          <el-input v-model="form.tranCompany" placeholder="请输入物流公司" />
        </el-form-item>
        <el-form-item label="集装箱号" prop="boxNum">
          <el-input v-model="form.boxNum" placeholder="请输入集装箱号" />
        </el-form-item>
        <el-form-item label="货物名称" prop="goods">
          <el-input v-model="form.goods" placeholder="请输入货物名称" />
        </el-form-item>
        <el-form-item label="货重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入货重" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addForm">确 定</el-button>
        <el-button @click="addcancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/system/info";

export default {
  name: "Info",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 物流信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      addopen: false,
      //是否弹出更新
      updateopen: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        owner: null,
        ownerNum: null,
        tranCompany: null,
        boxNum: null,
        goods: null,
        weight: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询物流信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    updatecancel() {
      this.updateopen = false;
      this.reset();
    },
    addcancel() {
      this.addopen = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        owner: null,
        ownerNum: null,
        tranCompany: null,
        boxNum: null,
        goods: null,
        weight: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.addopen = true;
      this.title = "添加物流信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.updateopen = true;
        this.title = "修改物流信息";
      });
    },
    /** 提交按钮 */
    updateForm() {
     
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.updateopen = false;
              this.getList();
            });
    },
    //新增提交按钮
    addForm(){
      addInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.addopen = false;
              this.getList();
            });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除物流信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
