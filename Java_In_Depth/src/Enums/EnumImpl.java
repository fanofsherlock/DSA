package Enums;

public enum EnumImpl implements PrintInterface {
	Instance1(1) {
		@Override
		void printConstantName() {
			System.out.println(this.toString());
		}
	},

	Instance2 {
		@Override
		void printConstantName() {
			System.out.println(this.toString());
		}
	};

	abstract void printConstantName();

	private EnumImpl() {
	}

	private int id;

	private EnumImpl(int id) {
		this.id = id;
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		EnumImpl e = EnumImpl.Instance1;
		e.printConstantName();
		e.print("implements PrintInterface");

		EnumImpl e2 = EnumImpl.Instance2;
		e2.printConstantName();
		e2.print("implements PrintInterface");
	}
}
