namespace java com.haitao.rpc.thrift
service ThriftService{
	 string sayHello(1:string name)
	 Position helloNation(1:string name)
}

struct Position{
	1: i32 id;
	2: string name;
	3: list<string> featrue;
}