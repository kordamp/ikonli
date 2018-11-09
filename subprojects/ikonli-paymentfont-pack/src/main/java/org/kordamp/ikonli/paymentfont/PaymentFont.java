/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2018 Andres Almiray
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.ikonli.paymentfont;

import org.kordamp.ikonli.Ikon;

/**
 * @author Loïc Sculier aka typhon0
 */
public enum PaymentFont implements Ikon {
    // last is f073
    ALIPAY("pf-alipay", '\uf064'),
    AMAZON("pf-amazon", '\uf000'),
    AMAZON_PAY("pf-amazon-pay", '\uf072'),
    AMAZON_PAY_ALT("pf-amazon-pay-alt", '\uf073'),
    AMERICAN_EXPRESS("pf-american-express", '\uf001'),
    AMERICAN_EXPRESS_ALT("pf-american-express-alt", '\uf002'),
    APPLE_PAY("pf-apple-pay", '\uf04c'),
    ATM("pf-atm", '\uf003'),
    BANCONTACT_MISTER_CASH("pf-bancontact-mister-cash", '\uf050'),
    BANKOMAT("pf-bankomat", '\uf004'),
    BANK_TRANSFER("pf-bank-transfer", '\uf005'),
    BITCOIN("pf-bitcoin", '\uf006'),
    BITCOIN_SIGN("pf-bitcoin-sign", '\uf007'),
    BITPAY("pf-bitpay", '\uf061'),
    BPAY("pf-bpay", '\uf06b'),
    BRAINTREE("pf-braintree", '\uf008'),
    BTC("pf-btc", '\uf009'),
    CARD("pf-card", '\uf00a'),
    CARTA_SI("pf-carta-si", '\uf00b'),
    CASH("pf-cash", '\uf00c'),
    CASHCLOUD("pf-cashcloud", '\uf05e'),
    CASH_ON_DELIVERY("pf-cash-on-delivery", '\uf00d'),
    CASH_ON_PICKUP("pf-cash-on-pickup", '\uf053'),
    CB("pf-cb", '\uf00e'),
    CIRRUS("pf-cirrus", '\uf00f'),
    CIRRUS_ALT("pf-cirrus-alt", '\uf010'),
    CLICKANDBUY("pf-clickandbuy", '\uf011'),
    CONTACTLESS("pf-contactless", '\uf06c'),
    CONTACTLESS_ALT("pf-contactless-alt", '\uf06d'),
    CREDIT_CARD("pf-credit-card", '\uf012'),
    DANKORT("pf-dankort", '\uf04f'),
    DINERS("pf-diners", '\uf013'),
    DINERS_ALT("pf-diners-alt", '\uf065'),
    DIRECT_DEBIT("pf-direct-debit", '\uf069'),
    DISCOVER("pf-discover", '\uf014'),
    EC("pf-ec", '\uf015'),
    ELO("pf-elo", '\uf055'),
    ELO_ALT("pf-elo-alt", '\uf056'),
    EPS("pf-eps", '\uf016'),
    ETH("pf-eth", '\uf06e'),
    EUR("pf-eur", '\uf017'),
    FACTURE("pf-facture", '\uf018'),
    FATTURA("pf-fattura", '\uf019'),
    FLATTR("pf-flattr", '\uf01a'),
    GIROPAY("pf-giropay", '\uf01b'),
    GOOGLE_WALLET("pf-google-wallet", '\uf01c'),
    GOOGLE_WALLET_ALT("pf-google-wallet-alt", '\uf01d'),
    GPB("pf-gpb", '\uf01e'),
    GRATIPAY("pf-gratipay", '\uf01f'),
    GRATIPAY_SIGN("pf-gratipay-sign", '\uf05c'),
    HIPERCARD("pf-hipercard", '\uf066'),
    IDEAL("pf-ideal", '\uf020'),
    ILS("pf-ils", '\uf021'),
    INR("pf-inr", '\uf022'),
    INTERAC("pf-interac", '\uf04d'),
    INTERAC_ALT("pf-interac-alt", '\uf05f'),
    INVOICE("pf-invoice", '\uf023'),
    INVOICE_SIGN("pf-invoice-sign", '\uf024'),
    INVOICE_SIGN_ALT("pf-invoice-sign-alt", '\uf025'),
    INVOICE_SIGN_ALT_O("pf-invoice-sign-alt-o", '\uf026'),
    INVOICE_SIGN_O("pf-invoice-sign-o", '\uf027'),
    JCB("pf-jcb", '\uf028'),
    JPY("pf-jpy", '\uf029'),
    KLARNA("pf-klarna", '\uf060'),
    KRW("pf-krw", '\uf02a'),
    LTC("pf-ltc", '\uf06f'),
    MAESTRO("pf-maestro", '\uf02b'),
    MAESTRO_ALT("pf-maestro-alt", '\uf02c'),
    MASTERCARD("pf-mastercard", '\uf02d'),
    MASTERCARD_ALT("pf-mastercard-alt", '\uf02e'),
    MASTERCARD_SECURECODE("pf-mastercard-securecode", '\uf02f'),
    MERCADO_PAGO("pf-mercado-pago", '\uf058'),
    MERCADO_PAGO_SIGN("pf-mercado-pago-sign", '\uf059'),
    MOIP("pf-moip", '\uf051'),
    MULTIBANCO("pf-multibanco", '\uf05b'),
    OGONE("pf-ogone", '\uf030'),
    PAGSEGURO("pf-pagseguro", '\uf052'),
    PAYBOX("pf-paybox", '\uf031'),
    PAYLIFE("pf-paylife", '\uf032'),
    PAYMILL("pf-paymill", '\uf04e'),
    PAYPAL("pf-paypal", '\uf033'),
    PAYPAL_ALT("pf-paypal-alt", '\uf034'),
    PAYSAFECARD("pf-paysafecard", '\uf035'),
    PAYSHOP("pf-payshop", '\uf05a'),
    PAYU("pf-payu", '\uf057'),
    POSTEPAY("pf-postepay", '\uf036'),
    QUICK("pf-quick", '\uf037'),
    RECHNUNG("pf-rechnung", '\uf038'),
    RIPPLE("pf-ripple", '\uf039'),
    RUB("pf-rub", '\uf03a'),
    SAGE("pf-sage", '\uf054'),
    SEPA("pf-sepa", '\uf04a'),
    SEPA_ALT("pf-sepa-alt", '\uf04b'),
    SHOPIFY("pf-shopify", '\uf068'),
    SIX("pf-six", '\uf05d'),
    SKRILL("pf-skrill", '\uf03b'),
    SKRILL_ALT("pf-skrill-alt", '\uf067'),
    SODEXO("pf-sodexo", '\uf06a'),
    SOFORT("pf-sofort", '\uf03c'),
    SQUARE("pf-square", '\uf03d'),
    STRIPE("pf-stripe", '\uf03e'),
    TRUSTE("pf-truste", '\uf03f'),
    TRY("pf-try", '\uf040'),
    UNIONPAY("pf-unionpay", '\uf041'),
    USD("pf-usd", '\uf042'),
    VENMO("pf-venmo", '\uf062'),
    VERIFIED_BY_VISA("pf-verified-by-visa", '\uf043'),
    VERISIGN("pf-verisign", '\uf044'),
    VISA("pf-visa", '\uf045'),
    VISA_DEBIT("pf-visa-debit", '\uf063'),
    VISA_ELECTRON("pf-visa-electron", '\uf046'),
    VISA_PAY("pf-visa-pay", '\uf070'),
    WECHAT_PAY("pf-wechat-pay", '\uf071'),
    WESTERN_UNION("pf-western-union", '\uf047'),
    WESTERN_UNION_ALT("pf-western-union-alt", '\uf048'),
    WIRECARD("pf-wirecard", '\uf049');

    public static PaymentFont findByDescription(String description) {
        for (PaymentFont font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private char code;

    PaymentFont(String description, char code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public char getCode() {
        return code;
    }
}