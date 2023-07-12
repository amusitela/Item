<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="作业号" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入作业号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="船公司" prop="shipcompany">
        <el-input
          v-model="queryParams.shipcompany"
          placeholder="请输入船公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="船名称" prop="chipname">
        <el-input
          v-model="queryParams.chipname"
          placeholder="请输入船名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作业开始时间" prop="ws">
        <el-date-picker clearable
          v-model="queryParams.ws"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择作业开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="作业结束时间" prop="we">
        <el-date-picker clearable
          v-model="queryParams.we"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择作业结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="始发时间" prop="start">
        <el-date-picker clearable
          v-model="queryParams.start"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择始发时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="到达时间" prop="end">
        <el-date-picker clearable
          v-model="queryParams.end"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="作业港口" prop="port">
        <el-input
          v-model="queryParams.port"
          placeholder="请输入作业港口"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提单号" prop="tnum">
        <el-input
          v-model="queryParams.tnum"
          placeholder="请输入提单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集装箱箱号" prop="containernum">
        <el-input
          v-model="queryParams.containernum"
          placeholder="请输入集装箱箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="箱尺寸" prop="cc">
        <el-input
          v-model="queryParams.cc"
          placeholder="请输入箱尺寸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="启运地" prop="splace">
        <el-input
          v-model="queryParams.splace"
          placeholder="请输入启运地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地" prop="eplace">
        <el-input
          v-model="queryParams.eplace"
          placeholder="请输入目的地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作" prop="status">
        <el-input
          v-model="queryParams.status"
          placeholder="请输入操作"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="异常" prop="error">
        <el-input
          v-model="queryParams.error"
          placeholder="请输入异常"
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
          v-hasPermi="['clean:WORK:add']"
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
          v-hasPermi="['clean:WORK:edit']"
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
          v-hasPermi="['clean:WORK:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['clean:WORK:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
                    <el-button
                      color="#626aef" :dark="isDark" plain
                      size="mini"
                      @click="handleClean"
                    >治理数据</el-button>
                  </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="WORKList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="作业号" align="center" prop="num" />
      <el-table-column label="船公司" align="center" prop="shipcompany" />
      <el-table-column label="船名称" align="center" prop="chipname" />
      <el-table-column label="作业开始时间" align="center" prop="ws" width="250"/>

      <el-table-column label="作业结束时间" align="center" prop="we" width="250" />

      <el-table-column label="始发时间" align="center" prop="start" width="250" />
      <el-table-column label="到达时间" align="center" prop="end" width="250" />
      <el-table-column label="作业港口" align="center" prop="port" />
      <el-table-column label="提单号" align="center" prop="tnum" />
      <el-table-column label="集装箱箱号" align="center" prop="containernum" width="250" />
      <el-table-column label="箱尺寸" align="center" prop="cc" />
      <el-table-column label="启运地" align="center" prop="splace" />
      <el-table-column label="目的地" align="center" prop="eplace" />
      <el-table-column label="操作" align="center" prop="status" />
      <el-table-column label="异常" align="center" prop="error" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200">
        <template #default="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['clean:WORK:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['clean:WORK:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
                  v-show="total>0"
                  :total="total"
                  v-model:page="queryParams.pageNum"
                  v-model:limit="queryParams.pageSize"
                  @pagination="getList"
                />

    <!-- 添加或修改work对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="作业号" prop="num">
          <el-input v-model="form.num" placeholder="请输入作业号" />
        </el-form-item>
        <el-form-item label="船公司" prop="shipcompany">
          <el-input v-model="form.shipcompany" placeholder="请输入船公司" />
        </el-form-item>
        <el-form-item label="船名称" prop="chipname">
          <el-input v-model="form.chipname" placeholder="请输入船名称" />
        </el-form-item>
        <el-form-item label="作业开始时间" prop="ws">
          <el-date-picker clearable
            v-model="form.ws"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择作业开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="作业结束时间" prop="we">
          <el-date-picker clearable
            v-model="form.we"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择作业结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="始发时间" prop="start">
          <el-date-picker clearable
            v-model="form.start"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择始发时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="到达时间" prop="end">
          <el-date-picker clearable
            v-model="form.end"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择到达时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="作业港口" prop="port">
          <el-input v-model="form.port" placeholder="请输入作业港口" />
        </el-form-item>
        <el-form-item label="提单号" prop="tnum">
          <el-input v-model="form.tnum" placeholder="请输入提单号" />
        </el-form-item>
        <el-form-item label="集装箱箱号" prop="containernum">
          <el-input v-model="form.containernum" placeholder="请输入集装箱箱号" />
        </el-form-item>
        <el-form-item label="箱尺寸" prop="cc">
          <el-input v-model="form.cc" placeholder="请输入箱尺寸" />
        </el-form-item>
        <el-form-item label="启运地" prop="splace">
          <el-input v-model="form.splace" placeholder="请输入启运地" />
        </el-form-item>
        <el-form-item label="目的地" prop="eplace">
          <el-input v-model="form.eplace" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="操作" prop="status">
          <el-input v-model="form.status" placeholder="请输入操作" />
        </el-form-item>
        <el-form-item label="异常" prop="error">
          <el-input v-model="form.error" placeholder="请输入异常" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWORK, getWORK, delWORK, addWORK, updateWORK } from "@/api/clean/WORK";
import { upWork } from "@/api/clean/clean";
export default {
  name: "WORK",
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
      // work表格数据
      WORKList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      flag:0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        num: null,
        shipcompany: null,
        chipname: null,
        ws: null,
        we: null,
        start: null,
        end: null,
        port: null,
        tnum: null,
        containernum: null,
        cc: null,
        splace: null,
        eplace: null,
        status: null,
        error: null
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
    /** 查询work列表 */
    getList() {
      this.loading = true;
      listWORK(this.queryParams).then(response => {
        this.WORKList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        num: null,
        shipcompany: null,
        chipname: null,
        ws: null,
        we: null,
        start: null,
        end: null,
        port: null,
        tnum: null,
        containernum: null,
        cc: null,
        splace: null,
        eplace: null,
        status: null,
        error: null
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
      this.ids = selection.map(item => item.num)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
        this.flag=1
      this.reset();
      this.open = true;
      this.title = "添加work";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
        this.flag=0
      this.reset();
      const num = row.num || this.ids
      getWORK(num).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改work";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (    this.flag==0) {
            updateWORK(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWORK(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const nums = row.num || this.ids;
      this.$modal.confirm('是否确认删除work编号为"' + nums + '"的数据项？').then(function() {
        return delWORK(nums);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('clean/WORK/export', {
        ...this.queryParams
      }, `WORK_${new Date().getTime()}.xlsx`)
    },
    handleClean() {
             upWork().then(()=>{
          this.$modal.msgSuccess("治理成功");
        })
            }
  }
};
</script>
