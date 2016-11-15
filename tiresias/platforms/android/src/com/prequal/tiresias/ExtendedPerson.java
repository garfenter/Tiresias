package com.prequal.tiresias;

public class ExtendedPerson extends Person {
    private String nationality;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.nationality != null ? this.nationality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExtendedPerson other = (ExtendedPerson) obj;
        if ((this.nationality == null) ? (other.nationality != null) : !this.nationality.equals(other.nationality)) {
            return false;
        }
        return true;
    }

    public String D2() {
        return this.I;
    }

    public void E(final String i) {
        this.I = i;
    }

    public void F(final String h) {
        this.nationality = h;
    }

    public void G(final String j) {
        this.J = j;
    }

    public void H(final String k) {
        this.K = k;
    }

    public void I(final String l) {
        this.L = l;
    }

    public void J(final String m) {
        this.M = m;
    }

    public void K(final String n) {
        this.N = n;
    }

    public void L(final String o) {
        this.O = o;
    }

    public void M(final String p) {
        this.P = p;
    }

    public void N(final String q) {
        this.Q = q;
    }

    public void O(final String r) {
        this.R = r;
    }

    public void P(final String s) {
        this.S = s;
    }

    public void Q(final String t) {
        this.T = t;
    }

    public void R(final String u) {
        this.U = u;
    }

    public void S(final String v) {
        this.V = v;
    }
}
