const menu = {
    list() {
        return [
    {
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"科研获奖类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryKeyanhuojiang"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"科研论文类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryKeyanlunwen"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"科研项目类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryXiangmu"
                    }
                ],
                "menu":"基础数据管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"教师管理",
                        "menuJump":"列表",
                        "tableName":"jiaoshi"
                    }
                ],
                "menu":"教师管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"秘书管理",
                        "menuJump":"列表",
                        "tableName":"mishu"
                    }
                ],
                "menu":"秘书管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "报表",
                            "审核",
                            "修改",
                            "删除"
                        ],
                        "menu":"科研获奖管理",
                        "menuJump":"列表",
                        "tableName":"keyanhuojiang"
                    }
                ],
                "menu":"科研获奖管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "报表",
                            "审核",
                            "删除"
                        ],
                        "menu":"科研论文管理",
                        "menuJump":"列表",
                        "tableName":"keyanlunwen"
                    }
                ],
                "menu":"科研论文管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "审核",
                            "报表",
                            "删除"
                        ],
                        "menu":"科研项目管理",
                        "menuJump":"列表",
                        "tableName":"xiangmu"
                    }
					,
					{
                        "buttons":[
                            "查看",
                            "新增",
                            "审核",
                            "修改",
                            "报表",
                            "删除"
                        ],
                        "menu":"工作量管理",
                        "menuJump":"列表",
                        "tableName":"gongzuoliang"
                    }
                ],
                "menu":"科研项目管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"教师管理",
                        "menuJump":"列表",
                        "tableName":"jiaoshi"
                    }
                ],
                "menu":"教师管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "报表",
                            "审核"
                        ],
                        "menu":"科研获奖管理",
                        "menuJump":"列表",
                        "tableName":"keyanhuojiang"
                    }
                ],
                "menu":"科研获奖管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "审核",
                            "报表"
                        ],
                        "menu":"科研论文管理",
                        "menuJump":"列表",
                        "tableName":"keyanlunwen"
                    }
                ],
                "menu":"科研论文管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "审核",
                            "报表"
                        ],
                        "menu":"科研项目管理",
                        "menuJump":"列表",
                        "tableName":"xiangmu"
                    }
					,
					{
                        "buttons":[
                            "查看",
                            "审核",
                            "报表"
                        ],
                        "menu":"工作量管理",
                        "menuJump":"列表",
                        "tableName":"gongzuoliang"
                    }
                ],
                "menu":"科研项目管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"秘书",
        "tableName":"mishu"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除"
                        ],
                        "menu":"科研获奖管理",
                        "menuJump":"列表",
                        "tableName":"keyanhuojiang"
                    }
                ],
                "menu":"科研获奖管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除"
                        ],
                        "menu":"科研论文管理",
                        "menuJump":"列表",
                        "tableName":"keyanlunwen"
                    }
                ],
                "menu":"科研论文管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除"
                        ],
                        "menu":"科研项目管理",
                        "menuJump":"列表",
                        "tableName":"xiangmu"
                    }
					,
					{
                        "buttons":[
                            "查看",
                            "新增",
                            "删除"
                        ],
                        "menu":"工作量管理",
                        "menuJump":"列表",
                        "tableName":"gongzuoliang"
                    }
                ],
                "menu":"科研项目管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"教师",
        "tableName":"jiaoshi"
    }
]
    }
}
export default menu;
